package game2048.serviceImpl;

import game2048.models.Position;
import game2048.services.RandomPositionGeneratorService;

import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Implementing Singleton Pattern to always have one instance of this class
 */

public class RandomPositionGeneratorServiceImpl implements RandomPositionGeneratorService {
    private static RandomPositionGeneratorServiceImpl randomObj;
    private Random random;

    private RandomPositionGeneratorServiceImpl(){
        random = new Random();
    }

    public static RandomPositionGeneratorServiceImpl getInstance(){
        if(Objects.isNull(randomObj)){
            randomObj = new RandomPositionGeneratorServiceImpl();
        }
        return randomObj;
    }

    @Override
    public Position generateRandomPosition(List<Position> emptyPositions) {
        if(emptyPositions.isEmpty()){
            return null;
        } else {
            int size = emptyPositions.size();
            int index = this.random.nextInt(0, size);
            return emptyPositions.get(index);
        }
    }
}
