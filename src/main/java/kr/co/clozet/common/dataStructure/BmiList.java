package kr.co.clozet.common.dataStructure;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// height, weight, SSN(900101-1)
public class BmiList {
    @Test
    void BmiTest() {

    }
    @Data
    static class Bmi{
        private double weight, height;
        private String ssn;
    }
    interface BmiService{
        boolean save(Bmi bmi);

        Bmi update(Bmi bmi);

        Bmi update(int i, Bmi bmi);
        boolean remove(Bmi bmi);
        List<Bmi> findAll();
        Bmi findById(int i);
        Bmi findByGender(String gender);
    }
    static class BmiServiceImpl implements BmiService{
        private final List<Bmi> list;

        public BmiServiceImpl() {
            this.list = new ArrayList<>();
        }

        @Override
        public boolean save(Bmi bmi) {
            return list.add(bmi);
        }

        @Override
        public Bmi update(Bmi bmi) {
            return null;
        }

        @Override
        public Bmi update(int i, Bmi bmi) {
            return list.set(i, bmi);

        }

        @Override
        public boolean remove(Bmi bmi) {
            return list.remove(bmi);
        }

        @Override
        public List<Bmi> findAll() {
            return list;
        }

        @Override
        public Bmi findById(int i) {
            return list.get(i);
        }

        @Override
        public Bmi findByGender(String gender) {
            return null;
        }
    }
}
