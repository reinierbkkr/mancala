import { useMancalaGame } from "../contexts/MancalaGameContext";
import { Board } from "../components/Board";

export const Play = () => {
    const { gameState, setGameState } = useMancalaGame();

    return <div>
        {/* Player 1: {gameState?.players[0].name}<br />
        Player 2: {gameState?.players[1].name}<br /> */}
        <Board />
    </div>
};