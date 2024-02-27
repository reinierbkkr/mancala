type Props = {
    seedCount: Int;
};


export const Pit = (props: Props) => {
    const { seedCount } = props;

    return <div className="h-100 py-1 px-3 rounded-full text-xl border-4 hover:text-neutral-800  hover:bg-neutral-50 hover:border-neutral-50 duration-300 text-neutral-800 bg-neutral-50 border-neutral-50">
        {props.seedCount}
    </div>
        
} 

