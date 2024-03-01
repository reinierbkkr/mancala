import { useMancalaGame } from "../contexts/MancalaGameContext";
import { playPit } from "../services/api";
import { isGameState } from "../types";
import classNames from "classnames";

type Props = {
    player: number;
    index: number;
};

export const Pit = (props: Props) => {
    const { gameState, setGameState } = useMancalaGame();

    const { index } = props;
    const { player } = props;

    const hasTurn = gameState?.players[player].hasTurn
    const nrOfStones = gameState?.players[player].pits[index].nrOfStones

    const valid = hasTurn && (nrOfStones > 0)

    const onSubmit = async () => {
        const result = await playPit(player, index);

        if (isGameState(result)) {
            setGameState(result);
        } else {
            console.log(`${result.statusCode} ${result.statusText}`)
        }
    }
    
    return <button className={classNames(
        "py-1 px-3 rounded-full text-xl border-4",
        "text-neutral-800",
        "bg-neutral-50",  
        {"duration-300 hover:bg-neutral-100 hover:border-neutral-300": hasTurn && (nrOfStones>0)},
        {"cursor-not-allowed": hasTurn && (nrOfStones===0) },
        {"border-neutral-100": !hasTurn}
        
    )}
    onClick={() => onSubmit()}
    disabled={!valid}>
        <div className={classNames(
            "min-w-[23px]"
            )}>
            {gameState?.players[player].pits[index].nrOfStones}
        </div>
    </button>
        
} 


