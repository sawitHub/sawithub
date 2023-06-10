package com.example.sawithub.ui.hasilScan

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sawithub.databinding.ActivityHasilScanBinding
import com.example.sawithub.ui.scan.ScanActivity
import java.io.File

class HasilScanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHasilScanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHasilScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScanUlang.setOnClickListener{ moveToScan()}
    }

    private fun moveToScan() {
        val moveToScan = Intent(this, ScanActivity::class.java)
        launcherIntentCameraX.launch(moveToScan)
    }

    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CAMERA_X_RESULT) {
            val myFile = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.data?.getSerializableExtra("picture", File::class.java)
            } else {
                @Suppress("DEPRECATION")
                it.data?.getSerializableExtra("picture")
            } as? File
            val isBackCamera = it.data?.getBooleanExtra("isBackCamera", true) as Boolean
            myFile?.let { file ->
                binding.imageHasilFoto.setImageBitmap(BitmapFactory.decodeFile(file.path))
            }
        }
    }

    companion object {
        const val CAMERA_X_RESULT = 200
    }
}