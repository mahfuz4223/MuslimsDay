package dark.com.muslimdays.Azan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import dark.com.muslimdays.R;

public class AzanAdapter extends RecyclerView.Adapter<AzanAdapter.ViewHolder> {

    String title [];
    Context mContext;

    public AzanAdapter(String[] title, Context mContext) {
        this.title = title;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.azan_layout_raw,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(title[position]);
        holder.materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/2021-04-10-001.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 1){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/2021-04-10-002.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 2){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/2021-04-10-003.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 3){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/2021-04-10-004.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 4){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/2021-04-10-005.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 5){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/2021-04-10-006.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 6){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/2021-04-10-007.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 7){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/2021-04-10-008.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 8){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/2021-04-10-009.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 9){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/2021-04-10-010.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 10){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/2021-04-10-011.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 11){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/012.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 12){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/013.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 13){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/014.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 14){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/015.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 15){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/016.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 16){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/017.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 17){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/018.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 18){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/019.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 19){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/020.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 20){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/021.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 21){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/022.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 22){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/023.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 23){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/024.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 24){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/025.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 25){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/026.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 26){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/027.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 27){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/028.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 28){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/029.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 29){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/030.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 30){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/031.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 31){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/032.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 32){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/033.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 33){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/034.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 34){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/035.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 35){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/036.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 36){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/037.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 37){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/038.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 38){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/039.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 39){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/040.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 40){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/041.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 41){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/042.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 42){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/043.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 43){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/044.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 44){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/045.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 45){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/046.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 46){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/047.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 47){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/048.mp3");
                    mContext.startActivity(intent);
                }
                   if (position == 48){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/049.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 49){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/050.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 50){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/051.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 51){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/052.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 52){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/053.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 53){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/054.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 54){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/055.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 55){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/056.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 56){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/057.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 57){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/058.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 58){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/059.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 59){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/060.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 60){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/061.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 61){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/062.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 62){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/063.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 63){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/064.mp3");
                    mContext.startActivity(intent);
                }

                if (position == 64){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/065.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 65){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/066.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 66){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/067.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 67){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/068.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 68){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/069.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 69){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/070.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 70){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/071.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 71){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/072.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 72){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/073.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 73){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/074.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 74){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/075.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 75){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/076.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 76){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/077.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 77){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/078.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 78){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/079.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 79){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/080.mp3");
                    mContext.startActivity(intent);
                }

                if (position == 80){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/081.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 81){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/082.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 82){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/083.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 83){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/084.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 84){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/085.mp3");
                    mContext.startActivity(intent);
                }

                if (position == 85){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/086.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 86){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/087.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 87){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/088.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 88){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/089.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 89){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/090.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 90){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/091.mp3");
                    mContext.startActivity(intent);
                }

                if (position == 91){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/092.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 92){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/093.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 93){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/094.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 94){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/095.mp3");
                    mContext.startActivity(intent);
                }

                if (position == 95){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/096.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 96){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/097.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 97){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/098.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 98){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/099.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 99){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/100.mp3");
                    mContext.startActivity(intent);
                }

                if (position == 100){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/101.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 101){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/102.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 102){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/103.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 103){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/104.mp3");
                    mContext.startActivity(intent);
                }

                if (position == 104){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/105.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 105){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/106.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 106){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/107.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 107){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/108.mp3");
                    mContext.startActivity(intent);
                }

                if (position == 108){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/109.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 109){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/110.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 110){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/111.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 111){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/112.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 112){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/113.mp3");
                    mContext.startActivity(intent);
                }
                if (position == 113){
                    Intent intent = new Intent(mContext,ExoPlayerActivity.class);
                    intent.putExtra("link","https://darkgamingbd.xyz/podcast/media/114.mp3");
                    mContext.startActivity(intent);
                }




            }
        });

    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView ;
        MaterialCardView materialCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.azan_name_tv);
            materialCardView = itemView.findViewById(R.id.azan_card);

        }
    }
}
