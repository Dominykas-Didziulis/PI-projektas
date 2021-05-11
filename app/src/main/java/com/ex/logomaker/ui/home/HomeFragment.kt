package com.ex.logomaker.ui.home

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ex.logomaker.R
import top.defaults.colorpicker.ColorPickerPopup
import top.defaults.colorpicker.ColorPickerPopup.ColorPickerObserver


@Suppress("DEPRECATION")
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var mDefaultColor = 0
    private var ind = 0;
    private var size = 14f;


    val Icons = arrayOf<Int>(
            R.drawable.t1,
            R.drawable.t2,
            R.drawable.t3,
            R.drawable.t4,
            R.drawable.t5,
            R.drawable.t6,
            R.drawable.t7,
            R.drawable.n1,
            R.drawable.n2,
            R.drawable.n3,
            R.drawable.n4,
            R.drawable.n5,
            R.drawable.n6,
            R.drawable.n7,
            R.drawable.n8,
            R.drawable.n9,
            R.drawable.n10,
            R.drawable.n11,
            R.drawable.n12,
            R.drawable.n13,
            R.drawable.n14,
            R.drawable.n15,
            R.drawable.n16,
            R.drawable.n17
    )

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

            root.findViewById<Button>(R.id.button11).setOnClickListener {

                if(ind < 0)
                {
                    ind = Icons.size-1
                }
                icon.setImageResource(Icons[ind])
                //output.setText(ind.toString())
                ind--
                if(ind < 0)
                {
                    ind = Icons.size-1
                }

            }

            root.findViewById<Button>(R.id.button13).setOnClickListener {
                if(ind >= Icons.size)
                {
                    ind = 0
                }
                icon.setImageResource(Icons[ind])
                //output.setText(ind.toString())
                ind++
                if(ind >= Icons.size)
                {
                    ind = 0
                }
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

                            root.findViewById<Button>(R.id.movetext).setOnClickListener{
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


            root.findViewById<Button>(R.id.button14).setOnClickListener{

                icon.setRotation(icon.getRotation()+45F)
            }

            root.findViewById<Button>(R.id.rotatetext).setOnClickListener{

                output.setRotation(output.getRotation()+45F)
            }
            root.findViewById<Button>(R.id.suptext).setOnClickListener{
                size += 4f
                output.setTextSize(TypedValue.COMPLEX_UNIT_SP,(size))
            }
            root.findViewById<Button>(R.id.sdwtext).setOnClickListener{
                size -= 4f
                output.setTextSize(TypedValue.COMPLEX_UNIT_SP,(size))
            }
            root.findViewById<Button>(R.id.button5).setOnClickListener{
                icon.getLayoutParams().height=(icon.getLayoutParams().height+100)
                icon.getLayoutParams().width=(icon.getLayoutParams().height+100)
                icon.requestLayout()
            }

            root.findViewById<Button>(R.id.button8).setOnClickListener{
                icon.getLayoutParams().height=icon.getLayoutParams().height-100
                icon.getLayoutParams().width=icon.getLayoutParams().height-100
                icon.requestLayout()
            }


            root.findViewById<Button>(R.id.button7).setOnClickListener{

                ColorPickerPopup.Builder(context).initialColor(
                        Color.RED) // set initial color
                        // of the color
                        // picker dialog
                        .enableBrightness(true) // enable color brightness
                        // slider or not
                        .enableAlpha(true) // enable color alpha
                        // changer on slider or
                        // not
                        .okTitle("Choose") // this is top right
                        // Choose button
                        .cancelTitle("Cancel") // this is top left
                        // Cancel button which
                        // closes the
                        .showIndicator(true) // this is the small box
                        // which shows the chosen
                        // color by user at the
                        // bottom of the cancel
                        // button
                        .showValue(true) // this is the value which
                        // shows the selected
                        // color hex code
                        // the above all values can be made
                        // false to disable them on the
                        // color picker dialog.
                        .build()
                        .show(view, object : ColorPickerObserver()
                        {
                                    override fun onColorPicked(color: Int)
                                    {
                                        // set the color
                                        // which is returned
                                        // by the color
                                        // picker
                                        mDefaultColor = color
                                        icon.setColorFilter(mDefaultColor)
                                    }
                        })
            }
            root.findViewById<Button>(R.id.colortext).setOnClickListener{

                ColorPickerPopup.Builder(context).initialColor(
                        Color.RED) // set initial color
                        // of the color
                        // picker dialog
                        .enableBrightness(true) // enable color brightness
                        // slider or not
                        .enableAlpha(true) // enable color alpha
                        // changer on slider or
                        // not
                        .okTitle("Choose") // this is top right
                        // Choose button
                        .cancelTitle("Cancel") // this is top left
                        // Cancel button which
                        // closes the
                        .showIndicator(true) // this is the small box
                        // which shows the chosen
                        // color by user at the
                        // bottom of the cancel
                        // button
                        .showValue(true) // this is the value which
                        // shows the selected
                        // color hex code
                        // the above all values can be made
                        // false to disable them on the
                        // color picker dialog.
                        .build()
                        .show(view, object : ColorPickerObserver()
                        {
                            override fun onColorPicked(color: Int)
                            {
                                // set the color
                                // which is returned
                                // by the color
                                // picker
                                mDefaultColor = color
                                output.setTextColor(mDefaultColor)
                            }
                        })
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