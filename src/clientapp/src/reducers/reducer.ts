import IState, {ById, IEntity} from "../types/State";
import initialState from "../context/initialState";
import {Action, SET_TEACHERS, SET_USERNAME,} from "../actions/actions";
import {Teacher} from "../api";

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
            const teachersObject: ById<Teacher> = action.payload.reduce((newObject: ById<Teacher>, teacher) => {
                return teacher.id
                    ? {
                    ...newObject,
                        [teacher.id]: {
                            ...teacher
                        }
                    }
                    : newObject;
            }, {})

            console.log(teachersObject)

            const allIds = action.payload
                .map(teacher => {
                    console.log(teacher)
                    return (teacher.id ? teacher.id : '')
                })
                .filter(teacherId => teacherId !== '')

            console.log(allIds);

            const newState = {
                ...state,
                teachers: {
                    byId: teachersObject,
                    allIds: allIds
                }

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