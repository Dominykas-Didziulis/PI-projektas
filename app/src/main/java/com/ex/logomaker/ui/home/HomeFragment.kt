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
    private var ind = 0
    private var size = 14f

    var index = 5

    val Icons = arrayOf<Int>(
            R.drawable.tra_1,R.drawable.tra_2,R.drawable.tra_3,R.drawable.tra_4,R.drawable.tra_5,R.drawable.tra_6,R.drawable.tra_7,R.drawable.tra_8,R.drawable.tra_9,R.drawable.tra_10,R.drawable.tra_11,R.drawable.tra_12
    )
    val Icons2 = arrayOf<Int>(
            R.drawable.w_1,R.drawable.w_2,R.drawable.w_3,R.drawable.w_4,R.drawable.w_5,R.drawable.w_6
    )
    val Icons3 = arrayOf<Int>(
            R.drawable.tr_1,R.drawable.tr_2,R.drawable.tr_3,R.drawable.tr_4,R.drawable.tr_5,R.drawable.tr_6,R.drawable.tr_7,R.drawable.tr_8
    )
    val Icons4 = arrayOf<Int>(
            R.drawable.t_1, R.drawable.t_2, R.drawable.t_3, R.drawable.t_4, R.drawable.t_5, R.drawable.t_6, R.drawable.t_7, R.drawable.t_8, R.drawable.t_9, R.drawable.t_10, R.drawable.t_11, R.drawable.t_12, R.drawable.t_13, R.drawable.t_14, R.drawable.t_15, R.drawable.t_16, R.drawable.t_17, R.drawable.t_18
    )
    val Icons5 = arrayOf<Int>(
            R.drawable.se_1,R.drawable.se_2,R.drawable.se_3,R.drawable.se_4,R.drawable.se_5,R.drawable.se_6,R.drawable.se_7,R.drawable.se_8,R.drawable.se_9,R.drawable.se_10,R.drawable.se_11,R.drawable.se_12,R.drawable.se_13,R.drawable.se_14,R.drawable.se_15
    )
    val Icons6 = arrayOf<Int>(
            R.drawable.s_1,R.drawable.s_2,R.drawable.s_3,R.drawable.s_4,R.drawable.s_5,R.drawable.s_6,R.drawable.s_7,R.drawable.s_8,R.drawable.s_9,R.drawable.s_10
    )
    val Icons7 = arrayOf<Int>(
            R.drawable.pe_1,R.drawable.pe_2,R.drawable.pe_3,R.drawable.pe_4,R.drawable.pe_5,R.drawable.pe_6,R.drawable.pe_7,R.drawable.pe_8,R.drawable.pe_9,R.drawable.pe_10,R.drawable.pe_11,R.drawable.pe_12,R.drawable.pe_13,R.drawable.pe_14,R.drawable.pe_15
    )
    val Icons8 = arrayOf<Int>(
            R.drawable.p_1,R.drawable.p_2,R.drawable.p_3,R.drawable.p_4,R.drawable.p_5,R.drawable.p_6,R.drawable.p_7,R.drawable.p_8,R.drawable.p_9
    )
    val Icons9 = arrayOf<Int>(
            R.drawable.o_1,R.drawable.o_2,R.drawable.o_3,R.drawable.o_4,R.drawable.o_5,R.drawable.o_6,R.drawable.o_7,R.drawable.o_8,R.drawable.o_9,R.drawable.o_10,R.drawable.o_11,R.drawable.o_12
    )
    val Icons10 = arrayOf<Int>(
            R.drawable.n_1,R.drawable.n_2,R.drawable.n_3,R.drawable.n_4,R.drawable.n_5,R.drawable.n_6,R.drawable.n_7,R.drawable.n_8,R.drawable.n_9,R.drawable.n_10,R.drawable.n_11,R.drawable.n_12, R.drawable.n_13, R.drawable.n_14, R.drawable.n_15, R.drawable.n_16, R.drawable.n_17
    )
    val Icons11 = arrayOf<Int>(
            R.drawable.a_1,R.drawable.a_2,R.drawable.a_3,R.drawable.a_4,R.drawable.a_5,R.drawable.a_6,R.drawable.a_7,R.drawable.a_8,R.drawable.a_9,R.drawable.a_10,R.drawable.a_11,R.drawable.a_12,R.drawable.a_13,R.drawable.a_14,R.drawable.a_15,R.drawable.a_16
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)

            : View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
            val root = inflater.inflate(R.layout.fragment_home, container, false)

            val output = root.findViewById<TextView>(R.id.textField)

            val icon = root.findViewById<ImageView>(R.id.imageView3)

            var IconsCur = arrayOf<Int>()

            IconsCur = Icons

            root.findViewById<Button>(R.id.button2).setOnClickListener {

                val input = root.findViewById<TextView>(R.id.Texteditor)


                output.setText(input.getText().toString())

            }

            root.findViewById<Button>(R.id.button11).setOnClickListener {

                if(ind <= 0)
                {
                    ind = IconsCur.size-1
                }
                icon.setImageResource(IconsCur[ind])
                //output.setText(ind.toString())
                ind--
                if(ind <= 0)
                {
                    ind = IconsCur.size-1
                }

            }

            root.findViewById<Button>(R.id.button13).setOnClickListener {
                if(ind >= IconsCur.size)
                {
                    ind = 0
                }
                icon.setImageResource(IconsCur[ind])
                //output.setText(ind.toString())
                ind++
                if(ind >= IconsCur.size)
                {
                    ind = 0
                }
            }
            root.findViewById<Button>(R.id.button66).setOnClickListener {
                index++

                if(index>11)
                {
                    index = 1
                }
                if(index == 1)
                {
                    IconsCur = Icons
                    root.findViewById<TextView>(R.id.textView3).setText("Transportation")
                    ind = 0
                }
                if(index == 2)
                {
                    IconsCur = Icons2
                    root.findViewById<TextView>(R.id.textView3).setText("Work")
                    ind = 0
                }
                if(index == 3)
                {
                    IconsCur = Icons3
                    root.findViewById<TextView>(R.id.textView3).setText("Travel")
                    ind = 0
                }
                if(index == 4)
                {
                    IconsCur = Icons4
                    root.findViewById<TextView>(R.id.textView3).setText("Technology")
                    ind = 0
                }
                if(index == 5)
                {
                    IconsCur = Icons5
                    root.findViewById<TextView>(R.id.textView3).setText("Services")
                    ind = 0
                }
                if(index == 6)
                {
                    IconsCur = Icons6
                    root.findViewById<TextView>(R.id.textView3).setText("School")
                    ind = 0
                }
                if(index == 7)
                {
                    IconsCur = Icons7
                    root.findViewById<TextView>(R.id.textView3).setText("Pets")
                    ind = 0
                }
                if(index == 8)
                {
                    IconsCur = Icons8
                    root.findViewById<TextView>(R.id.textView3).setText("Party")
                    ind = 0
                }
                if(index == 9)
                {
                    IconsCur = Icons9
                    root.findViewById<TextView>(R.id.textView3).setText("Ocean")
                    ind = 0
                }
                if(index == 10)
                {
                    IconsCur = Icons10
                    root.findViewById<TextView>(R.id.textView3).setText("Nature")
                    ind = 0
                }
                if(index == 11)
                {
                    IconsCur = Icons11
                    root.findViewById<TextView>(R.id.textView3).setText("Art")
                    ind = 0
                }
                if(index<1)
                {
                    index = 11
                }
            }
            root.findViewById<Button>(R.id.button67).setOnClickListener {
                index--


                if(index<1)
                {
                    index = 11
                }
                if(index == 1)
                {
                    IconsCur = Icons
                    root.findViewById<TextView>(R.id.textView3).setText("Transportation")
                    ind = 0
                }
                if(index == 2)
                {
                    IconsCur = Icons2
                    root.findViewById<TextView>(R.id.textView3).setText("Work")
                    ind = 0
                }
                if(index == 3)
                {
                    IconsCur = Icons3
                    root.findViewById<TextView>(R.id.textView3).setText("Travel")
                    ind = 0
                }
                if(index == 4)
                {
                    IconsCur = Icons4
                    root.findViewById<TextView>(R.id.textView3).setText("Technology")
                    ind = 0
                }
                if(index == 5)
                {
                    IconsCur = Icons5
                    root.findViewById<TextView>(R.id.textView3).setText("Services")
                    ind = 0
                }
                if(index == 6)
                {
                    IconsCur = Icons6
                    root.findViewById<TextView>(R.id.textView3).setText("School")
                    ind = 0
                }
                if(index == 7)
                {
                    IconsCur = Icons7
                    root.findViewById<TextView>(R.id.textView3).setText("Pets")
                    ind = 0
                }
                if(index == 8)
                {
                    IconsCur = Icons8
                    root.findViewById<TextView>(R.id.textView3).setText("Party")
                    ind = 0
                }
                if(index == 9)
                {
                    IconsCur = Icons9
                    root.findViewById<TextView>(R.id.textView3).setText("Ocean")
                    ind = 0
                }
                if(index == 10)
                {
                    IconsCur = Icons10
                    root.findViewById<TextView>(R.id.textView3).setText("Nature")
                    ind = 0
                }
                if(index == 11)
                {
                    IconsCur = Icons11
                    root.findViewById<TextView>(R.id.textView3).setText("Art")
                    ind = 0
                }
                if(index>11)
                {
                    index = 1
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