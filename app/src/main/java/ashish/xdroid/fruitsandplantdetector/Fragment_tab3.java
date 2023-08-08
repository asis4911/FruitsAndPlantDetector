package ashish.xdroid.fruitsandplantdetector;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.concurrent.ScheduledExecutorService;

public class Fragment_tab3 extends Fragment {


    private ScheduledExecutorService scheduler;
    private boolean isVisible;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3, container, false);

        return v;
    }
}
