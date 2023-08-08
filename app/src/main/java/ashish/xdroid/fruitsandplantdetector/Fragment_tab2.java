package ashish.xdroid.fruitsandplantdetector;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_tab2  extends Fragment {
    GridView gridView;
    String[] data;
    int[] imageID = {R.drawable.alovera, R.drawable.banana, R.drawable.bilimbi, R.drawable.cantalopu,
            R.drawable.casava, R.drawable.coconut, R.drawable.corn, R.drawable.cucumber, R.drawable.curcuma,
            R.drawable.eggplant, R.drawable.galangal, R.drawable.ginger, R.drawable.guava, R.drawable.kale,
            R.drawable.longbeans, R.drawable.mango, R.drawable.melon, R.drawable.orange, R.drawable.paddy,
            R.drawable.papaya, R.drawable.peperchili, R.drawable.pineapple, R.drawable.pomelo, R.drawable.shallot,
            R.drawable.soybeans, R.drawable.spinach, R.drawable.sweetpotatoes, R.drawable.tobacco, R.drawable.waterapple,
            R.drawable.watermelon};
    Button close;
    PopupWindow popupWindow;
    LinearLayout linearLayout1;
    TextView heading, content;
    private boolean isVisible;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2, container, false);
        gridView = v.findViewById(R.id.gridView);
        linearLayout1 = v.findViewById(R.id.ideas_layout);

        data = getResources().getStringArray(R.array.Suite);
        CustomGrid adapter = new CustomGrid(getActivity().getApplicationContext(), data, imageID);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Toast.makeText(getActivity().getApplicationContext(), "Aloevera", Toast.LENGTH_SHORT).show();
                }
                if (position == 1) {
                    Toast.makeText(getActivity().getApplicationContext(), "Banana", Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    Toast.makeText(getActivity().getApplicationContext(), "Bilimbi", Toast.LENGTH_SHORT).show();
                }
                if (position == 3) {
                    Toast.makeText(getActivity().getApplicationContext(), "Cantaloupe", Toast.LENGTH_SHORT).show();
                }
                if (position == 4) {
                    Toast.makeText(getActivity().getApplicationContext(), "Cassava", Toast.LENGTH_SHORT).show();
                }
                if (position == 5) {
                    Toast.makeText(getActivity().getApplicationContext(), "Coconut", Toast.LENGTH_SHORT).show();
                }
                if (position == 6) {
                    Toast.makeText(getActivity().getApplicationContext(), "Corn", Toast.LENGTH_SHORT).show();
                }
                if (position == 7) {
                    Toast.makeText(getActivity().getApplicationContext(), "Cucumber", Toast.LENGTH_SHORT).show();
                }
                if (position == 8) {
                    Toast.makeText(getActivity().getApplicationContext(), "Curcuma", Toast.LENGTH_SHORT).show();
                }
                if (position == 9) {
                    Toast.makeText(getActivity().getApplicationContext(), "Eggplant", Toast.LENGTH_SHORT).show();
                }
                if (position == 10) {
                    Toast.makeText(getActivity().getApplicationContext(), "Galangal", Toast.LENGTH_SHORT).show();
                }
                if (position == 11) {
                    Toast.makeText(getActivity().getApplicationContext(), "Ginger", Toast.LENGTH_SHORT).show();
                }
                if (position == 12) {
                    Toast.makeText(getActivity().getApplicationContext(), "Guava", Toast.LENGTH_SHORT).show();
                }
                if (position == 13) {
                    Toast.makeText(getActivity().getApplicationContext(), "Kale", Toast.LENGTH_SHORT).show();
                }
                if (position == 14) {
                    Toast.makeText(getActivity().getApplicationContext(), "Longbeans", Toast.LENGTH_SHORT).show();
                }
                if (position == 15) {
                    Toast.makeText(getActivity().getApplicationContext(), "Mango", Toast.LENGTH_SHORT).show();
                }
                if (position == 16) {
                    Toast.makeText(getActivity().getApplicationContext(), "Melon", Toast.LENGTH_SHORT).show();
                }
                if (position == 17) {
                    Toast.makeText(getActivity().getApplicationContext(), "Orange", Toast.LENGTH_SHORT).show();
                }
                if (position == 18) {
                    Toast.makeText(getActivity().getApplicationContext(), "Paddy", Toast.LENGTH_SHORT).show();
                }
                if (position == 19) {
                    Toast.makeText(getActivity().getApplicationContext(), "Papaya", Toast.LENGTH_SHORT).show();
                }
                if (position == 20) {
                    Toast.makeText(getActivity().getApplicationContext(), "Peper chili", Toast.LENGTH_SHORT).show();
                }
                if (position == 21) {
                    Toast.makeText(getActivity().getApplicationContext(), "Pineapple", Toast.LENGTH_SHORT).show();
                }
                if (position == 22) {
                    Toast.makeText(getActivity().getApplicationContext(), "Pomelo", Toast.LENGTH_SHORT).show();
                }
                if (position == 23) {
                    Toast.makeText(getActivity().getApplicationContext(), "Shallot", Toast.LENGTH_SHORT).show();
                }
                if (position == 24) {
                    Toast.makeText(getActivity().getApplicationContext(), "Soybeans", Toast.LENGTH_SHORT).show();
                }
                if (position == 25) {
                    Toast.makeText(getActivity().getApplicationContext(), "Spinach", Toast.LENGTH_SHORT).show();
                }
                if (position == 26) {
                    Toast.makeText(getActivity().getApplicationContext(), "Sweet Potatoes", Toast.LENGTH_SHORT).show();
                }
                if (position == 27) {
                    Toast.makeText(getActivity().getApplicationContext(), "Tobacco", Toast.LENGTH_SHORT).show();
                }
                if (position == 28) {
                    Toast.makeText(getActivity().getApplicationContext(), "Waterapple", Toast.LENGTH_SHORT).show();
                }
                if (position == 29) {
                    Toast.makeText(getActivity().getApplicationContext(), "Watermelon", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return v;
    }
}
