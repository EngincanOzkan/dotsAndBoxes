package edu.ktu.dotsandboxes;
public class box {
    private int blocked; //1 for blue player, 2 for red player
    private int wall1, wall2, wall3, wall4; //top right bottom left, can take player number
    public box(){ setReset(); }

    public void setReset(){
        blocked = 0;  wall1 = 0;  wall2 = 0; wall3 = 0; wall4 = 0;
    }

    public void setWhoWin(int player){   blocked = player; }

    //player must be 1 or 2
    public int setWall1(int player){
        wall1 = player;
        if(wall2 != 0 && wall3 != 0 && wall4 != 0){
            setWhoWin(player);
            return player;
        }else {
            if (player == 1) return 2;
            else return 1;
        }
    }

    public int setWall2(int player){
        wall2 = player;
        if(wall1 != 0 && wall3 != 0 && wall4 != 0){
            setWhoWin(player);
            return player;
        }else {
            if (player == 1) return 2;
            else return 1;
        }
    }

    public int setWall3(int player){
        wall3 = player;
        if(wall2 != 0 && wall1 != 0 && wall4 != 0){
            setWhoWin(player);
            return player;
        }
        else {
            if (player == 1) return 2;
            else return 1;
        }
    }

    public int setWall4(int player){
        wall4 = player;
        if(wall2 != 0 && wall3 != 0 && wall1 != 0){
            setWhoWin(player);
            return player;
        }else {
            if (player == 1) return 2;
            else return 1;
        }
    }

    public int getwhowin(){
        return blocked;
    }
}
