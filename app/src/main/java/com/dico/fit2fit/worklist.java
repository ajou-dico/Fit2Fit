package com.dico.fit2fit;

public class worklist {
    private String burpee, crunch, jumpinjack, legrasie, lunge, plank, pushup, situp, squat;
    public worklist(String work1, String work2, String work3, String work4,
                    String work5, String work6, String work7, String work8, String work9){

        burpee = work1;
        crunch = work2;
        jumpinjack = work3;
        legrasie = work4;
        lunge = work5;
        plank = work6;
        pushup = work7;
        situp = work8;
        squat = work9;

    }

    static String[] words = {
            "burpee",
            "crunch",
            "jumpingjack",
            "legraise",
            "lunge",
            "plank",
            "pushup",
            "situp",
            "squat"
    };
    static int images[] = {R.drawable.ic_burpee, R.drawable.ic_crunch, R.drawable.ic_jumpingjack,
            R.drawable.ic_legraise, R.drawable.ic_lunge, R.drawable.ic_plank,
            R.drawable.ic_pushup,R.drawable.ic_situp,R.drawable.ic_squat
    };
}
