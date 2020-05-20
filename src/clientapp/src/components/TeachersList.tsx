import React, {FunctionComponent, useContext, useEffect} from 'react';
import {DispatchContext, StateContext} from "../context/AppContext";
import {getTeachersAsync} from "../actions/actions";
import {getAllTeachers} from "../reducers/reducer";

interface TeacherProps {
}

type Props = TeacherProps;

const TeachersList: FunctionComponent<Props> = (props) => {
    const {state} = useContext(StateContext)
    const {dispatch} = useContext(DispatchContext)
    const teachers = getAllTeachers(state)

    useEffect(() => {
        dispatch(getTeachersAsync());
    }, [dispatch]);

    return (
        <div>
            <h1>Teachers List</h1>

            {teachers.map(teacher => {
                return (
                    <div key={teacher.id}>
                        Hello - {teacher.name}
                    </div>
                )
            })}

            {/*Option 2*/}
            {/*{state.teachers.allIds.map(id => {*/}
            {/*    return (*/}
            {/*        <div key={id}>*/}
            {/*            Hello - {state.teachers.byId[id].name}*/}
            {/*        </div>*/}
            {/*    )*/}
            {/*})}*/}
        </div>
    );
};

export default TeachersList;
