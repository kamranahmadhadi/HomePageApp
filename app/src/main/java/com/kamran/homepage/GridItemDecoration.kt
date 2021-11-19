import `in`.cgames.core.R
import `in`.cgames.core.superapp.dashboard.home.vh.DefaultGrid2x2ItemVH
import `in`.cgames.core.superapp.dashboard.home.vh.HeroBannerItemVH
import `in`.cgames.core.superapp.dashboard.home.vh.TitleItemVH
import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GridItemDecoration (context: Context): RecyclerView.ItemDecoration(){


    private val margin = context.resources.getDimensionPixelSize(R.dimen.default_recycler_item_space)
    private val startMargin = context.resources.getDimensionPixelSize(R.dimen.hero_banner_item_start_or_end)



    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {

        val manager = parent.layoutManager as? GridLayoutManager

        val params = view.layoutParams as? GridLayoutManager.LayoutParams

        val spanIndex = params?.spanIndex ?: 0

        val spanSize = params?.spanSize ?: 1

        val spanCount = manager?.spanCount ?: 1

        val pos = parent.getChildAdapterPosition(view)

        val isTop = pos == 0

        val isStart = spanIndex == 0

        //if sum of spanIndex and spanSize is equal to total span
        val isEnd = spanIndex + spanSize == spanCount

    android.util.Log.d("KAM_LOG", "SI=$spanIndex, SS=$spanSize, SC=$spanCount, POS=$pos, S=$isStart, E=$isEnd")

        when (parent.findContainingViewHolder(view)) {

            is HeroBannerItemVH -> {
                //ViewHolder be displayed in one column, put the margin upward when the top
                outRect.set(
                    startMargin,
                    if(isTop) margin else 0,
                    startMargin,
                    margin
                )
            }
            is DefaultGrid2x2ItemVH->{
                outRect.set(
                    if(isStart) startMargin else margin/2,
                    if(isTop) margin else 0,
                    if (isEnd) startMargin else margin/2,
                    margin
                )
            }

            is TitleItemVH->{
                    outRect.set(
                        if (isStart) startMargin else if ( isEnd ) margin/3 else margin * 2/3 ,
                        if (isTop) margin else 0 ,
                        if (isStart) startMargin / 3 else if (isEnd) margin else margin * 2/3,
                        margin)
            }

        }

    }
}
