import { Pit } from "../components/Pit";
import { useMancalaGame } from "../contexts/MancalaGameContext";


export const Board = () => {
    const { gameState, setGameState } = useMancalaGame();
    const nOfPits = 6;
    const pitsP1 = [];
    const pitsP2 = [];


    for (let i = 0; i < nOfPits; i++){
        pitsP1.push(
            <Pit seedCount={gameState?.players[0].pits[i].nrOfStones}/>
        )
        pitsP2.push(
            <Pit seedCount={gameState?.players[1].pits[5-i].nrOfStones}/>
        )
    }

    return <div>
        <div className="pt-4 flex-1 flex flex-row justify-center gap-2">{ pitsP2 }</div>
        <div className="pt-4 flex-1 flex flex-row justify-center gap-2">{ pitsP1 }</div>
    </div>
        
}