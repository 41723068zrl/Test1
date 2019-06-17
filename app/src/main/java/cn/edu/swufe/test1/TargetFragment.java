package cn.edu.swufe.test1;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TargetFragment extends Fragment {
    Button btn1,btn2;
    TextView targetView,presentView;
    float target,present;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.target_fragment,container);
//        presentView=(TextView)getActivity().findViewById(R.id.present);
//        Bundle bundle2=this.getArguments();
//        if(bundle2!=null){
//            present=bundle2.getFloat("newPresent_key",0.0f);
//        }
//        presentView.setText(String.valueOf(present+" "+"KG"));

        return view;

    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        targetView=(TextView)getActivity().findViewById(R.id.target);
        presentView=(TextView)getActivity().findViewById(R.id.present);

        btn1 = (Button) getActivity().findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), Target.class);
                startActivityForResult(intent1,1);
            }
        });

        btn2 = (Button) getActivity().findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), Present.class);
              //  startActivity(intent2);
                startActivityForResult(intent2,3);
            }
        });
//
//        Bundle bundle2=this.getArguments();
//      //  present=0.0f;
//        if(bundle2!=null){
//        present=bundle2.getFloat("newPresent_key",0.1f);
//
//        }
//        presentView.setText(String.valueOf(present+" "+"KG"));


    }

    public void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==1 && resultCode==2){

            Bundle bundle1=data.getExtras();
            target=bundle1.getFloat("newTarget_key",0.0f);
            targetView.setText(String.valueOf(target+" "+"KG"));

        }
        else if(requestCode==3 && resultCode==4){
            Bundle bundle=data.getExtras();
            present=bundle.getFloat("newPresent_key",0.0f);
            presentView.setText(String.valueOf(present+" "+"KG"));

        }

        super.onActivityResult(requestCode,resultCode,data);

    }




}
