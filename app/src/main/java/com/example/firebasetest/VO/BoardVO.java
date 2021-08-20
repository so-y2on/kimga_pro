package com.example.firebasetest.VO;

public class BoardVO {

    private String wirter;
    private String answer;
    private int img_board;
    private String board_date;

    public BoardVO(String wirter, String answer, int img_board, String board_date) {
        this.wirter = wirter;
        this.answer = answer;
        this.img_board = img_board;
        this.board_date = board_date;
    }

    public String getWirter() {
        return wirter;
    }

    public void setWirter(String wirter) {
        this.wirter = wirter;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getImg_board() {
        return img_board;
    }

    public void setImg_board(int img_board) {
        this.img_board = img_board;
    }

    public String getBoard_date() {
        return board_date;
    }

    public void setBoard_date(String board_date) {
        this.board_date = board_date;
    }
}
