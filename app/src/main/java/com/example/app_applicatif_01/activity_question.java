package com.example.app_applicatif_01;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class activity_question extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<Question> ensQuestions;
    private String nomP;
    private String prenomP;
    private int numQuest;

    private TextView bienvenue;
    private TextView question;

    private RadioButton CHhoixun;
    private RadioButton CHhoixdeux;
    private RadioButton CHhoixtrois;

    private Button button_Verifier;
    private Button button_Retour;

    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        RempQuestions();
        //On récupére les informations de la page précédentes dans une variable
        nomP = this.getIntent().getExtras().getString("EditNom");
        prenomP = this.getIntent().getExtras().getString("EditPrenom");
        numQuest = this.getIntent().getExtras().getInt("NumQuestion");

        //On affiche les informations que l'on vient de récupérer
        bienvenue = (TextView) findViewById(R.id.txtBienvenue);
        bienvenue.setText("Bonjour"+" "+nomP+" "+prenomP);

        question = (TextView) findViewById(R.id.txtLibelleQuestion);
        question.setText(question.getText()+" : "+ ensQuestions.get(numQuest).getUnLibelle());

        CHhoixun = (RadioButton) findViewById(R.id.rdBtnRep1);
        CHhoixun.setText(ensQuestions.get(numQuest).getOption1());

        CHhoixdeux = (RadioButton) findViewById(R.id.rdBtnRep2);
        CHhoixdeux.setText(ensQuestions.get(numQuest).getOption2());

        CHhoixtrois = (RadioButton) findViewById(R.id.rdBtnRep3);
        CHhoixtrois.setText(ensQuestions.get(numQuest).getOption3());

        button_Verifier = (Button) findViewById(R.id.btnValiderRep);
        button_Verifier.setOnClickListener(this);

        button_Retour = (Button) findViewById(R.id.btnRetour);
        button_Retour.setOnClickListener(this);

        result = (TextView) findViewById(R.id.txtReponse);




    }

    public void onClick(View v){

        //Ici on vérifie si le bouton coché est celui qui correspond a la bonne réponse
        if(v.getId() == R.id.btnValiderRep){
            if(ensQuestions.get(numQuest).getNumBonneRep() == 1){
                if(CHhoixun.isChecked()){
                    result.setText("Bonne Réponse !!!");
                }
                else{
                    result.setText("Mauvaise Réponse !!!");
                }
            }
        }

        if(v.getId() == R.id.btnValiderRep){
            if(ensQuestions.get(numQuest).getNumBonneRep() == 2){
                if(CHhoixdeux.isChecked()){
                    result.setText("Bonne Réponse !!!");
                }
                else{
                    result.setText("Mauvaise Réponse !!!");
                }
            }
        }

        if(v.getId() == R.id.btnValiderRep){
            if(ensQuestions.get(numQuest).getNumBonneRep() == 3){
                if(CHhoixtrois.isChecked()){
                    result.setText("Bonne Réponse !!!");
                }
                else{
                    result.setText("Mauvaise Réponse !!!");
                }
            }
        }

        //Permet de faire un retour en arrière tout en gardant les informations rentrés au préalable
        else if(v.getId() == R.id.btnRetour){
            onBackPressed();
        }

    }


    private void RempQuestions()
    {
        //On ajoute les questions et les choix avec les réponses
        ensQuestions = new ArrayList<Question>();
        ensQuestions.add(new Question("Je suis un chien qui se balade dans la Mystery Machine qui suis-je ?",
                "Rantanplan", "Rintintin","Scoubidoo", 3));
        ensQuestions.add(new Question("Je suis un alligator qui se prend pour un humain qui suis-je ?",
                "Wally Gator", "Krok Hodill","Kaïm Man", 1));
        ensQuestions.add(new Question("Je suis un chien habillé en kimono qui suis-je ?",
                "Hong Kong Fou Fou", "Kung Fou Star","KunFou Wouaf", 1));
        ensQuestions.add(new Question("J'ai une massue et je suis accompagné d'un perroquet qui suis-je ?",
                "Captaine America", "Capitaine Caverne","Capitaine Igloo", 2));
        ensQuestions.add(new Question("Je suis le pilier des PierraFeu qui suis-je ?",
                "Hoppy", "Puss","Fred", 3));
        ensQuestions.add(new Question("Dans la voiture j'accompagne Satanas qui suis-je ?",
                "Diabolo", "Grosse-Pomme","Gravillon", 1));
    }




}