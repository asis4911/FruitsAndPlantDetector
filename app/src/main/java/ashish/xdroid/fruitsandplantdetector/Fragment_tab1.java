package ashish.xdroid.fruitsandplantdetector;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ScheduledExecutorService;

import ashish.xdroid.fruitsandplantdetector.ml.Model;

public class Fragment_tab1 extends Fragment implements View.OnClickListener {
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;
    ImageView imageView;
    TextView result, confidence, confidencesText;
    Button picture;
    int imageSize = 224;
    LinearLayout linLay;
    private ScheduledExecutorService scheduler;
    private boolean isVisible;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmnet1, container, false);
        imageView = v.findViewById(R.id.imageView);
        result = v.findViewById(R.id.result);
        confidence = v.findViewById(R.id.confidence);
        picture = v.findViewById(R.id.button);
        confidencesText = v.findViewById(R.id.confidencesText);
        linLay = v.findViewById(R.id.theLinearLayoutId);
        picture.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        } else {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
        }

    }

    public void classifyImage(Bitmap image) throws IOException {
        try {
            Model model = Model.newInstance(getActivity().getApplicationContext());
            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3);
            byteBuffer.order(ByteOrder.nativeOrder());

            // get 1D array of 224 * 224 pixels in image
            int[] intValues = new int[imageSize * imageSize];
            image.getPixels(intValues, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());

            // iterate over pixels and extract R, G, and B values. Add to bytebuffer.
            int pixel = 0;
            for (int i = 0; i < imageSize; i++) {
                for (int j = 0; j < imageSize; j++) {
                    int val = intValues[pixel++]; //RGB
                    byteBuffer.putFloat(((val >> 16) & 0xFF) * (1.f / 255.f));
                    byteBuffer.putFloat(((val >> 8) & 0xFF) * (1.f / 255.f));
                    byteBuffer.putFloat((val & 0xFF) * (1.f / 255.f));
                }
            }
            inputFeature0.loadBuffer(byteBuffer);

            Model.Outputs output = model.process(inputFeature0);
            TensorBuffer outputFeature0 = output.getOutputFeature0AsTensorBuffer();

            float[] confidences = outputFeature0.getFloatArray();
            System.out.println("confidences : " + confidences);
            int maxPos = 0;
            float maxConfidences = 0;
            for (int i = 0; i < confidences.length; i++) {
                if (confidences[i] > maxConfidences) {
                    maxConfidences = confidences[i];
                    maxPos = i;
                }
            }
            int second = 0;
            float secondconf = 0;
            for (int i = 0; i < confidences.length; i++) {
                if (confidences[i] > secondconf && confidences[i] < maxConfidences) {
                    secondconf = confidences[i];
                    second = i;
                }
            }
            int third = 0;
            float thirdconf = 0;
            for (int i = 0; i < confidences.length; i++) {
                if (confidences[i] > thirdconf && confidences[i] < secondconf) {
                    thirdconf = confidences[i];
                    third = i;
                }
            }

            String[] classes = {"Aloevera", "Banana", "Bilimbi", "Cantaloupe", "Cassava", "Coconut", "Corn", "Cucumber", "Curcuma", "Eggplant", "Galangal", "Ginger", "Guava", "Kale", "Longbeans", "Mango", "Melon", "Orange", "Paddy", "Papaya", "Peper chili", "Pineapple", "Pomelo", "Shallot", "Soybeans", "Spinach", "Sweet Potatoes", "Tobacco", "Waterapple", "Watermelon"};

            confidencesText.setText("Confidnces:");
            linLay.setBackgroundColor(Color.parseColor("#ffffff"));
            float max_conf = 0;
            max_conf = confidences[maxPos];
            System.out.println("max conf : " + max_conf);
            if (max_conf >= 0.85) {
                result.setText(classes[maxPos]);
            } else {
                result.setText("No Idea!!!");
            }
            //result.setText(String.valueOf(confidences[maxPos]));
            //result.setText(classes[maxPos]);
            String s = "";

            for (int i = 0; i < classes.length; i++) {
                s += String.format("%s : %1f%%\n", classes[i], confidences[i] * 100);
            }
            String percent = "";
            percent = String.format("%s : %.02f%%\n", classes[maxPos], confidences[maxPos] * 100);
            percent += String.format("%s : %.02f%%\n", classes[second], confidences[second] * 100);
            percent += String.format("%s : %.02f%%\n", classes[third], confidences[third] * 100);
            confidence.setText(percent);
            model.close();
        } catch (IOException e) {
        }

    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {

            Bitmap image = (Bitmap) data.getExtras().get("data");
            int dimension = Math.min(image.getWidth(), image.getHeight());
            image = ThumbnailUtils.extractThumbnail(image, dimension, dimension);
            imageView.setImageBitmap(image);

            image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);
            try {
                classifyImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
