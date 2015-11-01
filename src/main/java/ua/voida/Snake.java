package ua.voida;

public class  Snake {
    public int direction;
    public int lenght = 2;

    public int snakeX[] = new int[SnakeGame.HEIGHT * SnakeGame.WIDTH];
    public int snakeY[] = new int[SnakeGame.HEIGHT * SnakeGame.WIDTH];
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
        for (int item = lenght - 1; item > 0 ; item--) {
            if ( snakeX[0] == snakeX[item] && snakeY[0] == snakeY[item]) {
                lenght /= 2;
            }
            if ( lenght < 2 ) {
                lenght = 2;
            }
            if (snakeX[0] > SnakeGame.WIDTH - 1) {
                snakeX[0] = 0;
            }
            if (snakeX[0] < 0) {
                snakeX[0] = SnakeGame.WIDTH - 1;
            }
            if (snakeY[0] > SnakeGame.HEIGHT - 1) {
                snakeY[0] = 0;
            }
            if (snakeY[0] < 0) {
                snakeY[0] = SnakeGame.HEIGHT;
            }

        }

    }
}
