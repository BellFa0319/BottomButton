package bellfa.com.bottombutton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import bellfa.com.bottombutton.databinding.FrgOneBinding

class OneFragment : Fragment() {

    private lateinit var binding: FrgOneBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FrgOneBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btn01.setOnClickListener {
            Toast.makeText(context, "Btn 1", Toast.LENGTH_SHORT).show()
        }
        binding.btn02.setOnClickListener {
            Toast.makeText(context, "Btn 2", Toast.LENGTH_SHORT).show()
        }
    }

}
