package org.example.daos;

import org.example.domain.Loan;

public interface LeningDaoServiceContract {

    void save(Loan loan);

    void update(Loan loan);

    void remove(Loan loan);

}
