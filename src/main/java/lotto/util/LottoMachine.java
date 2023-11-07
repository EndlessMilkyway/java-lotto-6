package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Tickets;
import lotto.enums.GlobalConstant;

public class LottoMachine {
    public Tickets generateTickets(int money) {
        List<Lotto> tickets = new ArrayList<>();
        int amount = money / GlobalConstant.DIVIDE_NUMBER.getValue();

        for (int loopCnt = 0; loopCnt < amount; loopCnt++) {
            List<Integer> ticket = Randoms.pickUniqueNumbersInRange(GlobalConstant.LOTTO_NUMBER_MIN.getValue(),
                    GlobalConstant.LOTTO_NUMBER_MAX.getValue(), GlobalConstant.LOTTO_NUMBER_SIZE.getValue());
            ticket.sort(Comparator.naturalOrder());
            tickets.add(new Lotto(ticket));
        }

        return new Tickets(tickets);
    }
}
