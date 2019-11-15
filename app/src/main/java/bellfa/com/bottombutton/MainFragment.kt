package bellfa.com.bottombutton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainFragment : Fragment() {

    private lateinit var pager : ViewPager
    private lateinit var tabLayout : TabLayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.frg_main, container, false)


        val item : List<String> = listOf("1", "2")
        pager = rootView.findViewById(R.id.pager) as ViewPager
        pager.adapter = ViewPagerAdpater(childFragmentManager,item)
        tabLayout = rootView.findViewById(R.id.tab) as TabLayout
        tabLayout.tabMode = TabLayout.MODE_FIXED
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        tabLayout.setupWithViewPager(pager)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position
            }
            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }
            override fun onTabSelected(p0: TabLayout.Tab?) {
            }
        })
        return rootView
    }


    private inner class ViewPagerAdpater(fm : FragmentManager, internal  var item : List<String>) : FragmentPagerAdapter(fm){

        override fun getItem(position: Int): Fragment {
            return when(position)  {
                0 -> OneFragment()
                1 -> TwoFragment()
                else -> TwoFragment()
            }
        }

        override fun getCount(): Int {
            return item.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return item[position]
        }

    }
}
