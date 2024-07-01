package game2048.services;

import game2048.models.Position;

import java.util.List;

public interface RandomPositionGeneratorService {
    Position generateRandomPosition(List<Position> emptyPositions);
}
