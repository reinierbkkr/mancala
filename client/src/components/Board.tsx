import { Pit } from "../components/Pit";
import { Kalaha } from "../components/Kalaha";

import { useMancalaGame } from "../contexts/MancalaGameContext";
import classNames from "classnames";


export const Board = () => {
    const { gameState, setGameState } = useMancalaGame();
    const nOfPits = 6;
    const pitsP1 = [];
    const pitsP2 = [];

    const player1Active = gameState?.players[0].hasTurn

    for (let i = 0; i < nOfPits; i++){
        pitsP1.push(
            <Pit player={0} index={i} key={i}/>
        )
        pitsP2.push(
            <Pit player={1} index={5-i} key={i}/>
        )
    }

    return <div className={classNames(
        "mb-6 pt-6 flex justify-center gap-2",
        {"flex-row-reverse": !player1Active}
        )}>
            <Kalaha player={1} />
            <div className={classNames(
                "flex flex-col",
                {"flex-col-reverse":!player1Active}
                )}>
                <div className={classNames(
                    "flex-1 flex flex-row justify-center gap-2",
                    {"pt-4 flex-row-reverse":!player1Active}
                    )}>
                    { pitsP2 }
                </div>
                <div className={classNames(
                    "flex-1 flex flex-row justify-center gap-2",
                    {"pt-4":player1Active},
                    {"flex-row-reverse":!player1Active}
                    )}>
                    { pitsP1 }
                </div>
            </div>
            <Kalaha player={0} />
    </div>
    
        
}