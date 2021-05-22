package Logic;

public class Message {
    // 타입 1=재고확인요청, 타입2 = 재고응답, 타입3 = 주소 요청, 타입4= 주소 응답, 타입 5=인증번호 전송
    private int myID = -1;
    private int targetID = -1;
    private int Type = -1;
    private double xAdress = -1;
    private double yAdress = -1;
    private int Title = -1;
    private int C_Number = -1;
    private boolean boolData = false;

    Message(int myid) {
        myID = myid;
    }

    public void translate(int myID, int targetID, int Type, double xAdress,
                          double yAdress, int Title, int C_Number, boolean boolData) {
        this.myID = myID;
        this.targetID = targetID;
        this.Type = Type;
        this.xAdress = xAdress;
        this.yAdress = yAdress;
        this.Title = Title;
        this.C_Number = C_Number;
        this.boolData = boolData;
    }

    //type1, 6
    void setmsg(int id, int type, int data) {
        targetID = id;
        Type = type;
        if (Type == 1) {
            Title = data;
            Message_Queue.MsgSend(this);
        }
        // 2021.05.21 수정 부분
        else if (Type == 6) {
            C_Number = data;
            Message_Queue.MsgSend(this);
        }
    }

    //type2
    void setmsg(int id, int type, boolean data) {
        targetID = id;
        Type = type;
        if (Type == 2) {
            boolData = data;
            Message_Queue.MsgSend(this);
        }
    }

    //type3
    void setmsg(int id, int type, int data1, int data2) {
        targetID = id;
        Type = type;
        if (Type == 3) {
            Title = data1;
            C_Number = data2;
            Message_Queue.MsgSend(this);
        }
    }

    //type4
    void setmsg(int id, int type) {
        targetID = id;
        Type = type;
        if (type == 4)
            Message_Queue.MsgSend(this);
    }

    //type5
    void setmsg(int id, int type, double data1, double data2) {
        targetID = id;
        Type = type;
        if (Type == 5) {
            xAdress = data1;
            yAdress = data2;
            Message_Queue.MsgSend(this);
        }
    }

    //  type7 2021.05.21 수정 부분
    void setmsg(int id, int type, int data1, boolean data2) {
        targetID = id;
        Type = type;
        if (Type == 7) {
            C_Number = data1;
            boolData = data2;
            Message_Queue.MsgSend(this);
        }
    }

    public int getMyID() {
        return myID;
    }

    public void setMyID(int myID) {
        this.myID = myID;
    }

    public int getTargetID() {
        return targetID;
    }

    public void setTargetID(int targetID) {
        this.targetID = targetID;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public double getxAdress() {
        return xAdress;
    }

    public void setxAdress(double xAdress) {
        this.xAdress = xAdress;
    }

    public double getyAdress() {
        return yAdress;
    }

    public void setyAdress(double yAdress) {
        this.yAdress = yAdress;
    }

    public int getTitle() {
        return Title;
    }

    public void setTitle(int title) {
        Title = title;
    }

    public int getC_Number() {
        return C_Number;
    }

    public void setC_Number(int c_Number) {
        C_Number = c_Number;
    }

    public boolean isBoolData() {
        return boolData;
    }

    public void setBoolData(boolean boolData) {
        this.boolData = boolData;
    }

}