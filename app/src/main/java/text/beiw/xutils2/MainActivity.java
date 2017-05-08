package text.beiw.xutils2;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import text.beiw.xutils2.fragments.Fragnemt1;
import text.beiw.xutils2.fragments.Fragnemt2;
import text.beiw.xutils2.fragments.Fragnemt3;
import text.beiw.xutils2.fragments.Fragnemt4;
import text.beiw.xutils2.fragments.Fragnemt5;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg;
    private FrameLayout frame;
    private int indox;
    private List<Fragment> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        rg = (RadioGroup) findViewById(R.id.rg);
        frame = (FrameLayout) findViewById(R.id.fragment);
        Fragnemt1 f1=new Fragnemt1();
        Fragnemt2 f2=new Fragnemt2();
        Fragnemt3 f3=new Fragnemt3();
        Fragnemt4 f4=new Fragnemt4();
        Fragnemt5 f5=new Fragnemt5();
        list.add(f1);
        list.add(f2);
        list.add(f3);
        list.add(f4);
        list.add(f5);

        showfragment(0);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        indox=0;
                        break;
                    case R.id.rb2:
                        indox=1;
                        break;
                    case R.id.rb3:
                        indox=2;
                        break;
                    case R.id.rb4:
                        indox=3;
                        break;
                    case R.id.rb5:
                        indox=4;
                        break;
                }
                showfragment(indox);
            }
        });
    }
    private void showfragment(int num){
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();

        if(!list.get(num).isAdded()){
            transaction.add(R.id.fragment,list.get(num));
        }
        for (int i=0;i<list.size();i++){
            if(num==i){
                transaction.show(list.get(i));
            }else{
                transaction.hide(list.get(i));
            }
        }
        transaction.commit();
    }
}
