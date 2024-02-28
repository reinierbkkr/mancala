import { useMancalaGame } from "../contexts/MancalaGameContext";
import classNames from "classnames";


type Props = {
    player: number;
};


export const Kalaha = (props: Props) => {
    const { gameState, setGameState } = useMancalaGame();

    const { player } = props;
    
    return <div className={classNames(
        "flex", "items-center",
        "py-1",
        "px-3",
        "rounded-full",
        "text-xl",
        "border-4",
        "duration-300",
        "text-neutral-800",
        "bg-neutral-50",
    )}>
        {gameState?.players[player].pits[6].nrOfStones}
    </div>
        
} 

