package com.example.sawithub.ui.scan

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sawithub.databinding.FragmentScanBinding
import com.example.sawithub.ml.Model
import com.example.sawithub.rotateFile
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.File


class ScanFragment : Fragment() {
    private var _binding: FragmentScanBinding? = null
    private val binding get() = _binding!!
    lateinit var imageView: Bitmap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScanBinding.inflate(inflater, container, false)

        val labels = requireActivity().application.assets.open("labels.txt").bufferedReader().readLines()

        val imageProcessor = ImageProcessor.Builder()
            .add(ResizeOp(224,224, ResizeOp.ResizeMethod.BILINEAR))
            .build()

        binding.btnScanFoto.setOnClickListener{startCameraX()}
        binding.btnScanProses.setOnClickListener{
            if(imageView == null) {
                Toast.makeText(context, "Harap masukkan Foto Terlebih Dahulu", Toast.LENGTH_SHORT).show()
            }

            var tensorImages = TensorImage(DataType.FLOAT32)
            tensorImages.load(imageView)

            tensorImages = imageProcessor.process(tensorImages)

            val model = Model.newInstance(requireContext())

            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
            inputFeature0.loadBuffer(tensorImages.buffer)

            val outputs = model.process(inputFeature0)
            val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

            var maxIdx = 0
            outputFeature0.forEachIndexed{index, fl ->
                if(outputFeature0[maxIdx] < fl) {
                    maxIdx = index
                }
            }

            binding.namaPenyakit.setText(labels[maxIdx])
            model.close()
        }

        return binding.root
    }

    private fun startCameraX() {
        val intent = Intent(context, ScanActivity::class.java)
        launcherIntentCameraX.launch(intent)
    }

    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == ScanFragment.CAMERA_X_RESULT) {
            val myFile = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.data?.getSerializableExtra("picture", File::class.java)
            } else {
                @Suppress("DEPRECATION")
                it.data?.getSerializableExtra("picture")
            } as? File
            val isBackCamera = it.data?.getBooleanExtra("isBackCamera", true) as Boolean
            myFile?.let { file ->
                rotateFile(file, isBackCamera)
                binding.previewImage.setImageBitmap(BitmapFactory.decodeFile(file.path))
                imageView = BitmapFactory.decodeFile(file.path)
            }
        }
    }


    companion object {
        const val CAMERA_X_RESULT = 200
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}