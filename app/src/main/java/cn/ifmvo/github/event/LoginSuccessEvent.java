package cn.ifmvo.github.event;

import cn.droidlover.xdroidmvp.utils.event.IBus;

/**
 * Created by ifmvo on 17-4-7.
 */

public class LoginSuccessEvent implements IBus.IEvent {
    @Override
    public int getTag() {
        return 1;
    }
}
