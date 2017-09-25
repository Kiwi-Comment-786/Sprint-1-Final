package blake.sprints1;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/18.
 */

public class Information implements Serializable {
    private String name;
    private String addresss;
    private String phonenumber;
    private String netlink;

    public Information(String name,String addresss,String phonenumber,String netlink){
        this.name=name;
        this.addresss=addresss;
        this.phonenumber=phonenumber;
        this.netlink=netlink;
    }

    public String getName() {
        return name;
    }

    public String getAddresss() {
        return addresss;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getNetlink() {
        return netlink;
    }
}
