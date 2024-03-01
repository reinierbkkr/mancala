import classNames from "classnames";
// import { To, useNavigate } from "react-router-dom";
import { startGame } from "../services/api";
import { isGameState } from "../types";
import { useState } from "react";
import { useMancalaGame } from "../contexts/MancalaGameContext";


export const RematchButton = () => {
    const [alert, setAlert] = useState<string | null>(null);
    const { gameState, setGameState } = useMancalaGame();
    // const { to, text, isActive } = props;
    const player1 = gameState.players[1].name
    const player2 = gameState.players[0].name

    const onSubmit = async () => {
        const result = await startGame(player1, player2);

        if (isGameState(result)) {
            setGameState(result);
        } else {
            setAlert(`${result.statusCode} ${result.statusText}`);
        }
    }

    return (<button className={classNames(
        "py-1 px-3 rounded-full text-xl border-4",
        "bg-neutral-50",
        "text-neutral-800 ",
        "duration-300 hover:bg-neutral-100 hover:border-neutral-300",        // { "text-neutral-300 bg-sogyo border-neutral-300": false },
        )}
        onClick={() => onSubmit()}>
        rematch
    </button>)
}