package com.dico.fit2fit;

public class userInfo {

    public String email;
    public String goalDate;
    public int goalExerciseTime;
    public int goalWeight;
    public int height;
    public String nickname;
    public int weight;

    public long workout_time;
    public String work1, work2, work3, work4, work5, work6, work7, work8, work9;
    public int Kcal;

    public userInfo(String e, String gDate, int gExerciseTime, int gWeight, int h, String nick, int w) {
        email = e;
        goalDate = gDate;
        goalExerciseTime = gExerciseTime;
        goalWeight = gWeight;
        height = h;
        nickname = nick;
        weight = w;
    }

}
