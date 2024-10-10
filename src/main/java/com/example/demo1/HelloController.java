package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class HelloController {



    public TextField Check_height;
    public TextField Check_weight;
    public Label print_bmi;

    private static final DecimalFormat df = new DecimalFormat("0.00");


    public void Calculate(ActionEvent actionEvent) {



            String temp_w = Check_weight.getText();

            String temp_h = Check_height.getText();


        if(temp_h.equals("")||temp_w.equals("")) {

            print_bmi.setText("Height or Weight Should not be empty");

        }else  if(!isNumeric(temp_w)||!isNumeric(temp_h)) {

            print_bmi.setText("Please Enter valid Height or Weight as Number");
        }else{

            Double height = Double.parseDouble(temp_h);

            Double weight = Double.parseDouble(temp_w);



                Double height_converted = height*0.3048;

                Double bmi = weight/(height_converted*height_converted);

                String bmI_res= df.format(bmi);

                String comment="";

                if(bmi<16){

                    comment ="Severly Underweight";

                }else if(bmi>=16 && bmi<=18.4){

                    comment ="Underweight";
                }else if(bmi>=18.5 && bmi<=24.3){

                    comment ="Normal";

                }else if(bmi>=25 && bmi<=29.9){

                    comment ="Overweight";

                }else if(bmi>=30 && bmi<=34.9){

                    comment ="Moderately Obese";

                }else if(bmi>=35 && bmi<=39.9){

                    comment ="Severly Obese";

                }else if(bmi>=40){

                    comment ="Morebidly Obese";

                }

                print_bmi.setText("Your BMI is "+bmI_res+" according to BMI you are "+comment);
            }











    }

    public void ResetThis(ActionEvent actionEvent) {
        Check_weight.setText("");
        Check_height.setText("");
        print_bmi.setText("");
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}