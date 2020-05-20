import {ById, IEntity} from "../types/State";
import {Teacher} from "../api";

// export const createEntities = <T>() => (entities: T []): IEntity<T>[] => {
//     const entitiesById: ById<T> = entities.reduce((newEntity: ById<T>, entity) => {
//         return entity.id
//             ? {
//                 ...newObject,
//                 [teacher.id]: {
//                     ...teacher
//                 }
//             }
//             : newObject;
//     }, {})
// }