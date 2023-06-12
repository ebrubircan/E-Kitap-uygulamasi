package com.example.mobilodevi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.example.mobilodevi.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.cesuryenidunya, R.drawable.farelerveinsanlar, R.drawable.geceyarisikutuphanesi, R.drawable.hayvanciftligi,
                R.drawable.masumiyetmuzesi, R.drawable.momo, R.drawable.sekerportakali, R.drawable.simyaci,
                R.drawable.solayagim, R.drawable.yasamak};

        String[] name = {"Cesur Yeni Dünya", "Fareler ve İnsanlar", "Gece Yarısı Kütüphanesi", "Hayvan Çiftliği",
                "Masumiyet Müzesi", "Momo", "Şeker Portakalı", "Simyacı", "Sol Ayağım", "Yaşamak"};

        String[] author = {"Aldous Huxley ", "John Steinbeck", "Matt Haig", "George Orwell", "Orhan Pamuk",
                "Michael Ende", "Jose Mauro De Vasconcelos", "Paulo Coelho", "Christy Brown", "Yu Hua"};

        String[] ozet = {
                "Romanını Birinci ve İkinci Dünya Savaşları arasındaki dönemde kaleme alan Aldous Huxley, " +
                        "okurlara 30’lu yılların karamsar atmosferini güçlü bir şekilde hissettiriyor. ",
                "Fareler ve İnsanlar, birbirine zıt karakterdeki iki mevsimlik tarım işçisinin, " +
                        "zeki George Milton ve onun güçlü kuvvetli ama akli dengesi bozuk yoldaşı Lennie Small’un öyküsünü anlatır.",
                "Gece Yarısı Kütüphanesi'ndeki kitaplar, Nora’ya yaşayabileceği başka hayatları denemek için bir hak verir " +
                        "ve Nora farklı seçimler yapsaydı hayatının nasıl şekilleneceğini görme fırsatını elde eder. ",
                "1940'lardaki 'reel sosyalizm'in eleştirisi olan bu roman, dünya edebiyatında 'yergi' türünün başyapıtlarından biridir.",
                "1975'te bir bahar günü başlayıp günümüze kadar gelen, İstanbullu zengin çocuğu Kemal ile uzak ve yoksul akrabası Füsun'un hikâyesi",
                "Momo, muhteşem bir dinleyicidir ve bunun için oldukça bol zamanı vardır. Bir gün hayaletimsi topluluk “duman adamlar” ortaya çıkar. " +
                        "İnce hesaplı planlar kurup insanların zamanını çalarlar. Onları durduracak tek kişiyse Momo’dur.",
                "Beş yaşındaki Zezé hemen her şeyi tek başına öğrenir.En yakın sırdaşıysa, anlattıklarına " +
                        "kulak veren ve Minguinho adını verdiği bir şeker portakalı fidanıdır. ",
                "Simyacı, İspanya'dan kalkıp Mısır Piramitlerinin eteklerinde hazinesini aramaya giden " +
                        "Endülüslü çoban Santiago'nun masalsı yaşamının felsefi öyküsü. ",
                "Doğuştan beyin felçli olan Christy Brown, konuşmasını ve hareketlerini kontrol edemiyordu. " +
                        "Ama zekâsı ve cesareti onun okuma ve yazmayı, resim yapmayı ve daktilo kullanmayı öğrenebilmesini, " +
                        "hatta bu kitabı yazabilmesini sağladı.",
                "Fugui,yıllar sonra, yaşlı öküzüyle tarlasını sürerken tanıştığı bir yabancıya hayatından söz etmeye başladığında, şımarık bir " +
                        "gencin başına gelenlerden fazlasını sayıp dökecektir bu yüzden"

        };

        ArrayList<User>userArrayList=new ArrayList<>();
        for (int i=0;i<imageId.length;i++){
            User user = new User(name[i],author[i],ozet[i],imageId[i]);
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("author",author[position]);
                i.putExtra("ozet",ozet[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);



            }
        });
    }
}


