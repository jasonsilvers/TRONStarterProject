import IState, {ById, IEntity} from "../types/State";
import initialState from "../context/initialState";
import {Action, SET_TEACHERS, SET_USERNAME,} from "../actions/actions";
import {Teacher} from "../api";
import {createEntities} from "../utilities/utils";

//Used to update state
const reducer = (state: IState = initialState, action: Action): IState => {

    /**
     * Reducer Switch statements are split in to categories
     *  1
     */

    /**
     * Event Switch Cases
     */
    switch (action.type) {
        case SET_USERNAME: {
            return {
                ...state,
                user: {
                    ...state.user,
                    name: action.payload
                }
            }
        }
        case SET_TEACHERS: {

            const teacherEntities = createEntities<Teacher>(action.payload)

            const newState = {
                ...state,
                teachers: teacherEntities
            }

            console.log(newState);

            return newState;
        }
        default:
            return state;
    }

}

export default reducer;

//Selectors - Allows extraction of data from the store state
//export const getState = (state: IState) => state
export const getAllTeachers = (state: IState) => state.teachers.allIds.map(teacherId => state.teachers.byId[teacherId]);