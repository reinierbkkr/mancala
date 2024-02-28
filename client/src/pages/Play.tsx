import { useMancalaGame } from "../contexts/MancalaGameContext";
import { Board } from "../components/Board";
import classNames from "classnames";

export const Play = () => {
    const { gameState, setGameState } = useMancalaGame();
    const player1 = gameState?.players[0].name
    const player2 = gameState?.players[1].name
    const activeplayer = gameState?.players[0].hasTurn ? player1 : player2
    const hasGameEnded = gameState?.gameStatus.endOfGame
    const winner = gameState?.gameStatus.winner

    const gameStatus = hasGameEnded ? <div>{winner} has won!</div> : <div>It's player {activeplayer}'s turn</div>

    return <div>
        <div className="pt-6 text-center">
            {/* <h4 className="text-xl font-semibold"> Player: {player2} </h4> */}
            <h4 className={classNames("text-xl", "font-semibold", {"underline": player2===activeplayer})}>Player: {player2}</h4>
        <Board />
        <h4 className={classNames("text-xl", "font-semibold", {"underline": player1===activeplayer})}>Player: {player1}</h4><br />
            {gameStatus}
        </div>
    </div>
};

