import { useMancalaGame } from "../contexts/MancalaGameContext";

type Props = {
    player: Int;
};


export const Kalaha = (props: Props) => {
    const { gameState, setGameState } = useMancalaGame();

    const { player } = props;
    
    return <div className="py-1 px-3 rounded-full text-xl border-4 hover:text-neutral-800  hover:bg-neutral-50 hover:border-neutral-50 duration-300 text-neutral-800 bg-neutral-50 border-neutral-50">
        {gameState?.players[player].pits[6].nrOfStones}
    </div>
        
} 

