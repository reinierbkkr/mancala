import { useMancalaGame } from "../contexts/MancalaGameContext";
import { playPit } from "../services/api";
import { isGameState } from "../types";

type Props = {
    player: number;
    index: number;
};


export const Pit = (props: Props) => {
    const { gameState, setGameState } = useMancalaGame();

    const { index } = props;
    const { player } = props;



    const onSubmit = async () => {
        const result = await playPit(player, index);

        if (isGameState(result)) {
            setGameState(result);
        } else {
            console.log(`${result.statusCode} ${result.statusText}`)
        }
    }
    
    return <div className="py-1 px-3 rounded-full text-xl border-4 hover:text-neutral-800  hover:bg-neutral-50 hover:border-neutral-50 duration-300 text-neutral-800 bg-neutral-50 border-neutral-50"
    onClick={() => onSubmit()}>
        {gameState?.players[player].pits[index].nrOfStones}
    </div>
        
} 


