package dev.xionjames.gnip.check;

import dev.xionjames.gnip.util.Const;

public class IcmpHostChecker extends HostChecker {

    public IcmpHostChecker(String host) {
        super(host);
        this.checkerKey = Const.CHECKER_KEY_ICMP;
    }

    @Override
    public boolean check() {
        // TODO Auto-generated method stub
        return false;
    }

}