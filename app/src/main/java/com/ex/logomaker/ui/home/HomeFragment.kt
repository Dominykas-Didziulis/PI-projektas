package com.ex.logomaker.ui.home

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ex.logomaker.R
import android.text.Layout as Layout1


@Suppress("DEPRECATION")
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
            val root = inflater.inflate(R.layout.fragment_home, container, false)


            val output = root.findViewById<TextView>(R.id.textField)

            val icon = root.findViewById<ImageView>(R.id.imageView3)



            root.findViewById<Button>(R.id.button2).setOnClickListener {

                val input = root.findViewById<TextView>(R.id.Texteditor)


                output.setText(input.getText().toString())

            }


            root.findViewById<Button>(R.id.button3).setOnClickListener{


                root.setOnTouchListener(object : View.OnTouchListener
                {
                    override fun onTouch(v: View?, event: MotionEvent): Boolean
                    {
                        if (event.action == MotionEvent.ACTION_DOWN)
                        {
                            val xp = event.x.toInt()
                            val yp = event.y.toInt()

                            root.findViewById<Button>(R.id.button).setOnClickListener{
                                output.x = xp.toFloat()
                                output.y = yp.toFloat()
                            }
                            root.findViewById<Button>(R.id.button4).setOnClickListener{
                                icon.x = xp.toFloat()
                                icon.y = yp.toFloat()
                            }
                        }
                        return true
                    }
                })

            }


            root.findViewById<Button>(R.id.button12).setOnClickListener{

                val picture =ImageSave(root)

                MediaStore.Images.Media.insertImage(context?.getContentResolver(),picture,"image","image")

            }




        return root
    }

    fun ImageSave(view: View): Bitmap{
        val returnedBitmap = Bitmap.createBitmap(view.width, (view.height/2), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(returnedBitmap)
        val bgDrawable = view.background
        if(bgDrawable != null) bgDrawable.draw(canvas)
        else canvas.drawColor(Color.WHITE)
        view.draw(canvas)
        return returnedBitmap
    }
}