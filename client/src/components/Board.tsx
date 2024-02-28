import { Pit } from "../components/Pit";
import { Kalaha } from "../components/Kalaha";

import { useMancalaGame } from "../contexts/MancalaGameContext";


export const Board = () => {
    const { gameState, setGameState } = useMancalaGame();
    const nOfPits = 6;
    const pitsP1 = [];
    const pitsP2 = [];

    console.log(gameState);


    for (let i = 0; i < nOfPits; i++){
        pitsP1.push(
            <Pit player={0} index={i}/>
        )
        pitsP2.push(
            <Pit player={1} index={5-i}/>
        )
    }

    return <div>
        <Kalaha player={1} />
        <div>
            <div className="pt-4 flex-1 flex flex-row justify-center gap-2">{ pitsP2 }</div>
            <div className="pt-4 flex-1 flex flex-row justify-center gap-2">{ pitsP1 }</div>
        </div>
        <Kalaha player={0} />
    </div>
        
}