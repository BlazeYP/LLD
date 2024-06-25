package game2048.services;

import game2048.models.Position;

import java.util.Set;

public interface RandomPositionGeneratorService {
    Position generateRandomPosition(int row, int col, Set<Position> occupiedPositions);
}
