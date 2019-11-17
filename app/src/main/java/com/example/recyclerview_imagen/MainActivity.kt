package com.example.recyclerview_imagen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.get
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_image.view.*

class MainActivity : AppCompatActivity(), ViewSwitcher.ViewFactory {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val items = ArrayList<Imagen>()
        items.add(Imagen(R.drawable.bosque))
        items.add(Imagen(R.drawable.rocosas))
        items.add(Imagen(R.drawable.tucan))
        items.add(Imagen(R.drawable.ballena))
        items.add(Imagen(R.drawable.margaritas))
        items.add(Imagen(R.drawable.rio))
        items.add(Imagen(R.drawable.sunset))
        items.add(Imagen(R.drawable.tortuga))

        val recView = findViewById<RecyclerView>(R.id.recyclerView)

        recView.setHasFixedSize(true)

        val adaptador = ImagesAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        /*recView.setLayoutManager(StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL))*/



       recView.itemAnimator = DefaultItemAnimator()

        val imageSwitcher = findViewById(R.id.imageswitcher) as ImageSwitcher
        imageSwitcher.setFactory(this)
        imageSwitcher.inAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        imageSwitcher.outAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)

        /*val imagen = findViewById(R.id.idimagen) as ImageView*/
        /*imagen.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                imageSwitcher.setImageDrawable(imagen.getDrawable())
            }
        })
*/
        adaptador.onClick = {
            Toast.makeText(this@MainActivity, ""+ recView.getChildAdapterPosition(it), Toast.LENGTH_LONG).show()
            imageSwitcher.setImageResource(items[recView.getChildAdapterPosition(it)].imagen)
        }

    }
    override fun makeView(): View {
        val imageView = ImageView(this)
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        imageView.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return imageView
    }
}
