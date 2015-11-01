package ua.voida;

public class  Snake {
    public int direction = 3;
    public int lenght = 2;

    public int snakeX[] = new int[100];
    public int snakeY[] = new int[100];
    public Snake(int x0, int y0, int x1, int y1) {
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;
    }
    public void move() {
        for (int item = lenght; item > 0 ; item--) {
            snakeX[item] = snakeX[item - 1];
            snakeY[item] = snakeY[item - 1];
        }
        switch (direction) {
            case 0 : {
                snakeX[0]++;
            } break;
            case 1 : {
                snakeY[0]++;
            } break;
            case 2 : {
                snakeX[0]--;
            } break;
            case 3 : {
                snakeY[0]--;
            }
        }
    }
}
