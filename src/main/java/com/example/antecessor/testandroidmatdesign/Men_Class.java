package com.example.antecessor.testandroidmatdesign;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.renderscript.Double2;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by antecessor on 03/01/2017.
 */

public class Men_Class extends Activity {
    TextView Agev, Waistv, Hipv, presv, TCHv, HDLv;
    SeekBar Age, Waist, Hip, pressure, TCH;
    CheckBox Diabet, Smoker, FM;
    RadioButton M, W;
    Button Calc;
    BarGraphSeries<DataPoint> series;
    GraphView graph;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.men_layout);
        Init();


    Calc.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){

          ClickwithCalc();

        if (val1 < 0) {
            Toast.makeText(getApplicationContext(), "Please fill all items", Toast.LENGTH_LONG).show();

        } else {
            double r1=0,r2=0,r3=0;
           try {
                r1 = Double.parseDouble(String.format("%2.2f", val1));
                r2 = Double.parseDouble(String.format("%2.2f", val2));
                r3 = Double.parseDouble(String.format("%2.2f", val3));
           }
           catch (Exception e){
                r1 = val1;
                r2 = val2;
                r3 =val3;
           }
            series.resetData(new DataPoint[]{
                    new DataPoint(1, (r1)),
                    new DataPoint(2, (r2)),
                    new DataPoint(3, (r3))});
        }
            graph.refreshDrawableState();


    }


    }


    );
        Calc.performClick();

}
    void Init(){
        Age=(SeekBar)findViewById(R.id.Age);
        Waist=(SeekBar)findViewById(R.id.Waist);
        Hip=(SeekBar)findViewById(R.id.Hip);
        pressure=(SeekBar)findViewById(R.id.Pres);
        TCH=(SeekBar)findViewById(R.id.TCH);
          M=(RadioButton)findViewById(R.id.Mand);
        W=(RadioButton)findViewById(R.id.Womand);
        Diabet=(CheckBox)findViewById(R.id.Diabetes);
        Smoker=(CheckBox)findViewById(R.id.Smoker);
        FM=(CheckBox)findViewById(R.id.FM);

         graph = (GraphView) findViewById(R.id.graph);
        series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(1, 0),
                new DataPoint(2, 5),
                new DataPoint(3, 3),

        });
        graph.addSeries(series);
// styling
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });
        series.setSpacing(50);

// draw values on top
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.WHITE);



        Agev=(TextView)findViewById(R.id.valueAge);
        Waistv=(TextView)findViewById(R.id.valueWaist);
        Hipv=(TextView)findViewById(R.id.valueHip);
        presv=(TextView)findViewById(R.id.valuePres);
        TCHv=(TextView)findViewById(R.id.valueTCH);

        Calc=(Button)findViewById(R.id.Calc);

        Age.incrementProgressBy(1);
        Waist.incrementProgressBy(1);
        Hip.incrementProgressBy(1);
        pressure.incrementProgressBy(1);
        TCH.incrementProgressBy(1);

        Hip.setProgress(50);
        Waist.setProgress(20);

        TCH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TCHv.setText(progress+83+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        pressure.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                presv.setText(progress+60+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        Hip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Hipv.setText(progress+53+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Waist.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Waistv.setText(progress+54+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Agev.setText(progress+35+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }




double val1,val2,val3;

    private void ClickwithCalc(){
        double Tchcat2=0,Tchcat3=0,Tchcat4=0,Tchcat5=0,sbpcat2=0,sbpcat3=0,sbpcat4=0;
        int sex,age,waist,hip,pres,tch,diabet,smoker,fm;
        age=Age.getProgress()+35;
        waist=Waist.getProgress()+51;
        hip=Hip.getProgress()+53;
        pres=pressure.getProgress()+60;
        tch=TCH.getProgress()+68;

        if(Diabet.isChecked()){
            diabet=1;
        }
        else{
            diabet=0;
        }


        if(Smoker.isChecked()){
            smoker=1;
        }
        else{
            smoker=0;
        }

        if(FM.isChecked()){
            fm=1;
        }
        else{
            fm=0;
        }

        if(W.isChecked()){
            sex=1;
        }else{
            sex=0;
        }


        double WHR=waist/hip;
        if(sex==0){ // man
            if(WHR>=.95)
            {
                WHR=1;
            }
            else{
                WHR=0;
            }

        }
        else{

            if(WHR>=.8)
            {
                WHR=1;
            }
            else{
                WHR=0;
            }
        }
        if(tch>=150 && tch<200){
            Tchcat2=1;
        }else if(tch>=200 && tch<250){
            Tchcat3=1;
        }
        else if(tch>=250 && tch<300){
            Tchcat4=1;
        }
        else if(tch>=300){
            Tchcat5=1;
        }

        if(pres>=120 && pres<139){
            sbpcat2=1;
        }
        else if(pres>=140 && pres<=159){
            sbpcat3=1;
        }else if(pres>=160){
            sbpcat4=1;
        }



         val1= 0.03759*(age-50.70)+0.40182*(fm-0.05)+0.20759*(Tchcat2-0.3264)+0.34201*(Tchcat3-0.3527)+0.45316*(Tchcat4-0.1646)+0.54847*(Tchcat5-0.0622)+0.63041*(diabet-0.11)+0.45643*(sbpcat2-0.3536)+0.73697*(sbpcat3-0.127)+1.0467*(sbpcat4-0.0729)+(-0.28957)*(sex-0.51)+0.28974*(smoker-0.22)+0.26989*(WHR-0.68);
        val1=(1-Math.pow(0.97577599,Math.exp(val1)))*100;
         val2= 0.03759*(age-50.70)+0.40182*(0-0.05)+0.20759*(0-0.3264)+0.34201*(0-0.3527)+0.45316*(0-0.1646)+0.54847*(0-0.0622)+0.63041*(0-0.11)+0.45643*(0-0.3536)+0.73697*(0-0.127)+1.0467*(0-0.0729)+(-0.28957)*(sex-0.51)+0.28974*(0-0.22)+0.26989*(0-0.68);
        val2=(1-Math.pow(0.97577599,Math.exp(val2)))*100;
         val3= 0.03759*(50.7-50.70)+0.40182*(0-0.05)+0.20759*(0-0.3264)+0.34201*(1-0.3527)+0.45316*(0-0.1646)+0.54847*(0-0.0622)+0.63041*(0-0.11)+0.45643*(1-0.3536)+0.73697*(0-0.127)+1.0467*(0-0.0729)+(-0.28957)*(1-0.51)+0.28974*(0-0.22)+0.26989*(1-0.68);
        val3=(1-Math.pow(0.97577599,Math.exp(val3)))*100;













    }



}
