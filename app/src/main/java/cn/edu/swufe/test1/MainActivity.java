package cn.edu.swufe.test1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends FragmentActivity {

    private Fragment mFragments[];
    private RadioGroup radioGroup;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private RadioButton rbtTarget,rbtRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragments=new Fragment[2];
        fragmentManager=getSupportFragmentManager();
        mFragments[0]=fragmentManager.findFragmentById(R.id.fragment_Target);
        mFragments[1]=fragmentManager.findFragmentById(R.id.fragment_Record);
        fragmentTransaction=fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]);
        fragmentTransaction.show(mFragments[0]).commit();

        rbtTarget=(RadioButton)findViewById(R.id.radioTarget) ;
        rbtRecord=(RadioButton)findViewById(R.id.radioRecord) ;
        rbtTarget.setBackgroundResource(R.drawable.shape3);

        radioGroup=(RadioGroup)findViewById(R.id.bottomGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i("radioGroup","checkId="+checkedId);
                fragmentTransaction=fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]);
                rbtTarget.setBackgroundResource(R.drawable.shape2);
                rbtRecord.setBackgroundResource(R.drawable.shape2);

                switch (checkedId){
                    case R.id.radioTarget:
                        fragmentTransaction.show(mFragments[0]).commit();
                        rbtTarget.setBackgroundResource(R.drawable.shape3);

                        break;

                    case R.id.radioRecord:
                        fragmentTransaction.show(mFragments[1]).commit();
                        rbtRecord.setBackgroundResource(R.drawable.shape3);


                        break;


                    default:
                        break;
                }
            }
        });
    }
}
