import * as _ from 'lodash';

export class FoldingType {
  public static Expanded: FoldingType = new FoldingType('node-expanded fa');
  public static Collapsed: FoldingType = new FoldingType('node-collapsed fa');
  public static Leaf: FoldingType = new FoldingType('node-leaf fa');

  public constructor(private _cssClass: string) {
  }

  public get cssClass(): string {
    return this._cssClass;
  }
}

export interface TreeModel {
  id: number;
  type: number;
  value: string | RenamableNode;
  pid?: number;
  children?: TreeModel[];
  settings?: TreeModelSettings;
  _status?: TreeStatus;
  _foldingType?: FoldingType;
}

export class TreeModelSettings {
  /**
   * "static" property when set to true makes it impossible to drag'n'drop tree or call a menu on it.
   * @name TreeModelSettings#static
   * @type boolean
   * @default false
   */

  public constructor(private staticTree?: boolean) {
  }

  public static merge(sourceA: TreeModel, sourceB: TreeModel): TreeModelSettings {
    return _.defaults({}, _.get(sourceA, 'settings'), _.get(sourceB, 'settings'), {staticTree: false});
  }
}

export interface Ng2TreeSettings {
  /**
   * Indicates root visibility in the tree. When true - root is invisible.
   * @name Ng2TreeSettings#rootIsVisible
   * @type boolean
   */
  rootIsVisible?: boolean;
}
export interface Ng2TreeOptions {
  isExpanded: boolean;
  nodeName: string;
  folderName: string;
}

export enum TreeStatus {
  New,
  Modified,
  IsBeingRenamed
}

export interface RenamableNode {
  /**
   * Set new value of the renamable node. Implementation of this method is up to user.
   * @param {string} name - A new value of the node.
   */
  setName(name: string): void;

  /**
   * Get string representation of the node. Implementation of this method is up to user.
   * @returns {string} - A node string representation.
   */
  toString(): string;
}
