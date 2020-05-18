import React, {FunctionComponent, useContext, useEffect} from 'react';
import {DispatchContext, StateContext} from "../context/AppContext";
import {setUserName} from "../actions/actions";

interface OwnProps {
}

type Props = OwnProps;

const Hello: FunctionComponent<Props> = (props) => {

    const {state} = useContext(StateContext)
    const {dispatch} = useContext(DispatchContext)

    useEffect(() => {
      setTimeout(() => {
            dispatch(setUserName("Frank"));
      }, 5000)
    }, [dispatch]);

    return (
        <div>
          Welcome - {state.user.name}
        </div>
    );
};

export default Hello;
